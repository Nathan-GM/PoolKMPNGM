import androidx.compose.ui.test.*
import dam.nathan.poolkmpngm.Formulario
import kotlin.test.Test
class PruebaEjemplo {
    @OptIn(ExperimentalTestApi::class)
    @Test
    fun textFieldExisteTest() = runComposeUiTest {
        setContent {
            Formulario()
        }

        onNodeWithTag("m3").assertExists()
        onNodeWithTag("ph").assertExists()
        onNodeWithTag("g").assertExists()
        onNodeWithTag("resultado").assertExists()
    }
    @OptIn(ExperimentalTestApi::class)
    @Test
    fun resultadoCorrectoTest() = runComposeUiTest {
        setContent {
            Formulario()
        }
        onNodeWithTag("m3").performTextInput("43")
        onNodeWithTag("ph").performTextInput("7.0")
        onNodeWithTag("g").performTextInput("5")

        val result = (7.4 - 7.0) * 10 * 43 * 5

        onNodeWithTag("resultado").assertTextEquals(result.toString())
    }
    @OptIn(ExperimentalTestApi::class)
    @Test
    fun resultadoNegativoCorrectoTest() = runComposeUiTest {
        setContent {
            Formulario()
        }
        onNodeWithTag("m3").performTextInput("43")
        onNodeWithTag("ph").performTextInput("7.5")
        onNodeWithTag("g").performTextInput("5")

        val result = (7.4 - 7.5) * 10 * 43 * 5

        onNodeWithTag("resultado").assertTextEquals(result.toString())
    }




}