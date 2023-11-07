package com.woogear.compose_note.ui.helper

import android.net.Uri
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import androidx.navigation.contains
import androidx.navigation.get
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

fun NavHostController.clearStackAndNavigate(route: String) {
    navigate(route = route) {
        popUpTo(id = graph.id) {
            inclusive = true
        }
    }
}

fun NavHostController.popUntilAndNavigate(
    routeToPop: String,
    routeToNavigate: String,
) {
    navigate(route = routeToNavigate) {
        if (graph.contains(routeToPop)) {
            popUpTo(id = graph[routeToPop].id) {
                inclusive = false
            }
        }
    }
}

fun NavHostController.popAndNavigate(route: String) {
    navigate(route = route) {
        currentDestination?.let {
            popUpTo(id = it.id) { inclusive = true }
        }
    }
}

inline fun <reified T : Any?> encodeArgument(arg: T): String {
    return Uri.encode(Json.encodeToString(arg))
}

inline fun <reified T : Any> NavBackStackEntry.getRequiredArgument(key: String): T {
    val decoded = Uri.decode(checkNotNull(arguments?.getString(key)))
    return Json.decodeFromString(decoded)
}

inline fun <reified T : Any?> NavBackStackEntry.getOptionalArgument(key: String): T? {
    return arguments?.getString(key)?.let {
        Json.decodeFromString(Uri.decode(it))
    }
}

inline fun <reified T : Any> SavedStateHandle.getRequiredArgument(key: String): T {
    val decoded = Uri.decode(checkNotNull(this[key]))
    return Json.decodeFromString(decoded)
}

inline fun <reified T : Any?> SavedStateHandle.getOptionalArgument(key: String): T? {
    return Uri.decode(this[key])?.let {
        Json.decodeFromString(it)
    }
}
