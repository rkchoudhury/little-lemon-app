package com.littlelemon.littlelemon.screens

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.littlelemon.littlelemon.R
import com.littlelemon.littlelemon.components.CategoryItem
import com.littlelemon.littlelemon.components.MenuItem
import com.littlelemon.littlelemon.constants.Categories
import com.littlelemon.littlelemon.databases.AppDatabaseInstance
import com.littlelemon.littlelemon.databases.MenuItemRoom
import com.littlelemon.littlelemon.navigations.Profile
import com.littlelemon.littlelemon.ui.theme.LittleLemonColor

@Composable
fun Dashboard(navController: NavHostController, context: Context) {
    val databaseInstance by lazy { AppDatabaseInstance(context) }
    val menuItems by databaseInstance.getMenuItems().observeAsState(emptyList())

    val (searchPhrase, setSearchPhrase) = remember {
        mutableStateOf("")
    }

    val (category, setCategory) = remember {
        mutableStateOf("")
    }

    var filteredItems = menuItems

    if (category.isNotEmpty()) {
        filteredItems = menuItems.filter { it.category == category }
    }

    if (searchPhrase.isNotEmpty()) {
        filteredItems = filteredItems.filter { it.title.contains(searchPhrase, ignoreCase = true) }
    }

    Column {
        HeaderView(navController)
        BannerView(searchPhrase, setSearchPhrase)
        CategorySection(category, setCategory)
        MenuItemList(filteredItems)
    }
}

@Composable
fun HeaderView(navController: NavHostController) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp, 10.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(id = R.drawable.little_lemon_logo),
            contentDescription = "little_lemon_logo",
            modifier = Modifier
                .weight(1f)
                .size(40.dp),
            alignment = Alignment.Center
        )
        Image(
            painter = painterResource(id = R.drawable.profile_icon),
            contentDescription = "profile_icon",
            modifier = Modifier
                .size(30.dp)
                .clickable {
                    navController.navigate(Profile.route)
                }
        )
    }
}

@Composable
fun BannerView(searchPhrase: String, setSearchPhrase: (String) -> Unit) {
    Column(
        modifier = Modifier
            .background(LittleLemonColor.green)
            .fillMaxWidth()
            .padding(10.dp, 15.dp)
    ) {
        Text(
            text = stringResource(id = R.string.restaurant_name),
            fontSize = 32.sp,
            color = LittleLemonColor.yellow,
            fontWeight = FontWeight.Medium,
            fontFamily = FontFamily.Serif,
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .weight(0.5f)
            ) {
                Text(
                    text = stringResource(id = R.string.restaurant_city),
                    fontSize = 24.sp,
                    color = LittleLemonColor.cloud,
                    fontWeight = FontWeight.Medium,
                    fontFamily = FontFamily.Serif,
                    modifier = Modifier.padding(0.dp, 0.dp, 0.dp, 15.dp)
                )
                Text(
                    text = stringResource(id = R.string.restaurant_desc),
                    fontSize = 14.sp,
                    color = LittleLemonColor.cloud,
                    fontWeight = FontWeight.Medium,
                    fontFamily = FontFamily.Serif,
                )
            }
            Image(
                painter = painterResource(id = R.drawable.upperpanelimage),
                contentDescription = "image",
                modifier = Modifier
                    .weight(0.5f)
                    .size(120.dp),
                alignment = Alignment.CenterEnd,
            )
        }
        TextInputView(searchPhrase, setSearchPhrase)
    }
}

@Composable
fun TextInputView(searchPhrase: String, setSearchPhrase: (String) -> Unit) {
    TextField(
        value = searchPhrase,
        onValueChange = {
            setSearchPhrase(it)
        },
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp, 15.dp, 10.dp, 0.dp)
            .background(LittleLemonColor.white),
        placeholder = { Text(text = "Enter search phrases") },
        leadingIcon = { Icon(imageVector = Icons.Default.Search, contentDescription = "") }
    )
}

@Composable
fun CategorySection(selectedCategory: String, setCategory: (String) -> Unit) {
    Column(modifier = Modifier.padding(20.dp, 10.dp)) {
        Text(
            text = stringResource(id = R.string.order_delivery).uppercase(),
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
        )
        LazyRow(contentPadding = PaddingValues(0.dp, 15.dp, 20.dp, 15.dp)) {
            items(Categories) { eachCategory ->
                CategoryItem(
                    label = eachCategory,
                    isSelectedItem = eachCategory == selectedCategory
                ) {
                    if (eachCategory == selectedCategory) {
                        setCategory("")
                    } else {
                        setCategory(eachCategory)
                    }
                }
            }
        }
    }
    Divider()
}

@Composable
fun MenuItemList(menuItems: List<MenuItemRoom>) {
    LazyColumn() {
        items(menuItems) { menuItem ->
            MenuItem(
                title = menuItem.title,
                details = menuItem.description,
                price = menuItem.price,
                imageUrl = menuItem.image
            )
        }
    }

}

@Composable
@Preview(showSystemUi = true)
fun PreviewDashboard() {
    Dashboard(rememberNavController(), LocalContext.current)
}