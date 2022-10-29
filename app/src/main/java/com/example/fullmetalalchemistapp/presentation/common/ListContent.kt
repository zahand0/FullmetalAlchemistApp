package com.example.fullmetalalchemistapp.presentation.common

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ContentAlpha
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.paging.LoadState
import androidx.paging.compose.LazyPagingItems
import androidx.paging.compose.items
import coil.compose.rememberAsyncImagePainter
import com.example.fullmetalalchemistapp.R
import com.example.fullmetalalchemistapp.domain.model.Hero
import com.example.fullmetalalchemistapp.domain.model.MilitaryRank
import com.example.fullmetalalchemistapp.navigation.Screen
import com.example.fullmetalalchemistapp.presentation.components.RatingWidget
import com.example.fullmetalalchemistapp.presentation.components.ShimmerEffect
import com.example.fullmetalalchemistapp.ui.theme.*
import com.example.fullmetalalchemistapp.util.Constants.BASE_URL

@Composable
fun ListContent(
    modifier: Modifier = Modifier,
    heroes: LazyPagingItems<Hero>,
    navController: NavHostController
) {
    Log.d("ListContent", heroes.loadState.toString())
    val result = handlePagingResult(heroes = heroes)
    if (result) {
        LazyColumn(
            contentPadding = PaddingValues(SMALL_PADDING),
            verticalArrangement = Arrangement.spacedBy(SMALL_PADDING)
        ) {
            items(
                items = heroes,
                key = { hero ->
                    hero.id
                }
            ) { hero ->
                hero?.let {
                    HeroItem(
                        hero = it,
                        navController = navController
                    )
                }
            }
        }
    }

}

@Composable
fun handlePagingResult(
    heroes: LazyPagingItems<Hero>
): Boolean {
    heroes.apply {
        val error = when {
            loadState.refresh is LoadState.Error -> loadState.refresh as LoadState.Error
            loadState.prepend is LoadState.Error -> loadState.prepend as LoadState.Error
            loadState.append is LoadState.Error -> loadState.append as LoadState.Error
            else -> null
        }

        return when {
            loadState.refresh is LoadState.Loading -> {
                ShimmerEffect()
                false
            }
            error != null -> {
                false
            }
            else -> true
        }
    }
}

@Composable
fun HeroItem(
    hero: Hero,
    navController: NavHostController
) {
    val painter = rememberAsyncImagePainter(
        model = "$BASE_URL${hero.image}",
        placeholder = painterResource(id = R.drawable.placeholder),
        error = painterResource(id = R.drawable.placeholder)
    )
    Box(
        modifier = Modifier
            .height(HERO_ITEM_HEIGHT)
            .clickable {
                navController.navigate(
                    Screen.Details.passHeroId(
                        heroId = hero.id
                    )
                )
            },
        contentAlignment = Alignment.BottomStart
    ) {
        Surface(shape = RoundedCornerShape(LARGE_PADDING)) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painter,
                contentDescription = hero.name,
                contentScale = ContentScale.Crop
            )
        }
        Surface(
            modifier = Modifier
                .fillMaxHeight(0.4f)
                .fillMaxWidth(),
            color = Color.Black.copy(alpha = ContentAlpha.medium),
            shape = RoundedCornerShape(
                bottomStart = LARGE_PADDING,
                bottomEnd = LARGE_PADDING
            )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(MEDIUM_PADDING)
            ) {
                Text(
                    text = hero.name,
                    color = LightCream100,
                    fontSize = MaterialTheme.typography.h5.fontSize,
                    fontWeight = FontWeight.Bold,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = hero.about,
                    color = Color.White.copy(alpha = 0.8f),
                    fontSize = MaterialTheme.typography.subtitle1.fontSize,
                    maxLines = 3,
                    overflow = TextOverflow.Ellipsis
                )
                Row(
                    modifier = Modifier.padding(top = SMALL_PADDING),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RatingWidget(
                        modifier = Modifier.padding(end = SMALL_PADDING),
                        rating = hero.rating,
                        starFilledColor = Amber300
                    )
                    Text(
                        text = "(${hero.rating})",
                        textAlign = TextAlign.Center,
                        color = Color.White.copy(alpha = ContentAlpha.medium)
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun HeroItemPreview() {
    FullmetalAlchemistAppTheme {
        HeroItem(
            hero = Hero(
                id = 1,
                name = "Roy Mustang",
                image = "",
                memorableQuotes = listOf(),
                alias = "",
                rating = 7.50,
                about = "Roy Mustang (ロイ・マスタング Roi Masutangu), also known as the Flame Alchemist (焔の錬金術師 Honō no Renkinjutsushi), is the tritagonist of the Fullmetal Alchemist series. He is a State Alchemist and officer in the Amestrian State Military. A hero of the Ishval Civil War and Edward Elric’s superior officer, Colonel Mustang is a remarkably capable commander who plans to become the next Führer of Amestris.",
                species = "",
                militaryRank = MilitaryRank(
                    type = "",
                    rankName = "",
                    img = ""
                ),
                abilities = listOf(),
                weapons = listOf()
            ),
            navController = rememberNavController()
        )
    }

}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun HeroItemPreviewNight() {
    FullmetalAlchemistAppTheme {
        HeroItem(
            hero = Hero(
                id = 1,
                name = "Roy Mustang",
                image = "",
                memorableQuotes = listOf(),
                alias = "",
                rating = 7.50,
                about = "Roy Mustang (ロイ・マスタング Roi Masutangu), also known as the Flame Alchemist (焔の錬金術師 Honō no Renkinjutsushi), is the tritagonist of the Fullmetal Alchemist series. He is a State Alchemist and officer in the Amestrian State Military. A hero of the Ishval Civil War and Edward Elric’s superior officer, Colonel Mustang is a remarkably capable commander who plans to become the next Führer of Amestris.",
                species = "",
                militaryRank = MilitaryRank(
                    type = "",
                    rankName = "",
                    img = ""
                ),
                abilities = listOf(),
                weapons = listOf()
            ),
            navController = rememberNavController()
        )
    }

}