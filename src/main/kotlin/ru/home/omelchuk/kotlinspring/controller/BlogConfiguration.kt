package ru.home.omelchuk.kotlinspring.controller

import ru.home.omelchuk.kotlinspring.domain.Article
import ru.home.omelchuk.kotlinspring.domain.User
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import ru.home.omelchuk.kotlinspring.repositories.ArticleRepository
import ru.home.omelchuk.kotlinspring.repositories.UserRepository

@Configuration
class BlogConfiguration {
    @Bean
    fun databaseInitializer(userRepository: UserRepository, articleRepository: ArticleRepository) = ApplicationRunner {

        val smaldini = userRepository.save(User("Andre", "Andrey", "Omelchuk"))
        articleRepository.save(
            Article(
                title = "Reactor Bismuth is out",
                headline = "Lorem ipsum",
                content = "dolor sit amet",
                author = smaldini
            )
        )
        articleRepository.save(
            Article(
                title = "Reactor Aluminium has landed",
                headline = "Lorem ipsum",
                content = "dolor sit amet",
                author = smaldini
            )
        )
    }
}