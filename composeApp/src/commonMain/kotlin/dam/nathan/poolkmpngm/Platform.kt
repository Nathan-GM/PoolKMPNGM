package dam.nathan.poolkmpngm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform