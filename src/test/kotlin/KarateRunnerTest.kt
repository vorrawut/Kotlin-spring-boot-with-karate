import com.intuit.karate.junit5.Karate

class KarateRunnerTest {
    @Karate.Test
    fun testAll(): Karate = Karate.run("classpath:features/cart.feature").relativeTo(javaClass)
}
