//package com.example.basketlyfe.graphs
//
//import androidx.navigation.NavGraphBuilder
//import androidx.navigation.NavHostController
//import androidx.navigation.compose.composable
//import androidx.navigation.navigation
//import com.example.basketlyfe.ui.view.Masuk
//import com.example.nestednavigationbottombardemo.graphs.Graph
//
//fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
//    navigation(
//        route = Graph.AUTHENTICATION,
//        startDestination = AuthScreen.Login.route
//    ) {
//        composable(route = AuthScreen.Login.route) {
//            Masuk(
//                onClick = {
//                    navController.popBackStack()
//                    navController.navigate(Graph.HOME)
//                },
//                onDaftarClick = {
////                    navController.navigate(AuthScreen.Daftar.route)
//                },
//            )
//        }
//        composable(route = AuthScreen.Daftar.route) {
//            Daftar(name = AuthScreen.Daftar.route) {}
//        }
//    }
//}
//
//sealed class AuthScreen(val route: String) {
//    object Login : AuthScreen(route = "MASUK")
//    object Daftar : AuthScreen(route = "DAFTAR")
//}