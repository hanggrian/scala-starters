# Scala Starters

![](https://github.com/hanggrian/scala-starters/raw/assets/logo.png)

Common Gradle project templates with emphasis on **Scala,** separated by target
platform and kind of distribution.

| | Plugins | Testing | Publishing | Website | Coverage | Max Heap Size
--- | :---: | :---: | :---: | :---: | :---: | :---:
jvm-app | [Scala], [Application] | [JUnit 5] | &cross; | [Cayman] | &check; | 2GB
jvm-library | [Scala] | [JUnit 5] | [Maven Central] | [ScalaDoc], [Minimal] | &check; | 2GB

## Frameworks

- JUnit testing framework with [Truth](https://truth.dev/) asserter.
- [WartRemover](https://www.wartremover.org/) code linter.
- [JaCoCo](https://docs.gradle.org/current/userguide/jacoco_plugin.html) code
  coverage.

## Project layout

- GitHub project layout:
  - GitHub [README](httgps://docs.github.com/en/repositories/managing-your-repositorys-settings-and-features/customizing-your-repository/about-readmes/),
    [LICENSE](https://docs.github.com/en/repositories/managing-your-repositorys-settings-and-features/customizing-your-repository/licensing-a-repository/),
    and [gitignore](https://docs.github.com/en/get-started/getting-started-with-git/ignoring-files/)
    file.
  - [EditorConfig](https://editorconfig.org/) enforces IDE settings.
  - [CircleCI](https://circleci.com/) to run test every commit, also triggers
    [Codecov](https://about.codecov.io/) integration within CircleCI.
- Gradle build tool:
  - [Kotlin DSL](https://docs.gradle.org/current/userguide/kotlin_dsl.html)
    scripts with properties delegation.
  - Apply plugin using [plugins DSL](https://docs.gradle.org/current/userguide/plugins.html).
  - [Version catalogs](https://docs.gradle.org/current/userguide/platforms.html)
    in TOML file to avoid typing unsafe dependencies.
- Website module:
  - [Pages Gradle Plugin](https://github.com/hendraanggrian/pages-gradle-plugin/)
    for generating webpage displaying README's content and documentation links.
  - [gradle-git-publish](https://github.com/ajoberstar/gradle-git-publish/)
    plugin, necessary for uploading to [GitHub Pages](https://pages.github.com/).

[Scala]: https://docs.gradle.org/current/userguide/scala_plugin.html
[Application]: https://docs.gradle.org/current/userguide/application_plugin.html
[JUnit 4]: https://junit.org/junit4/
[JUnit 5]: https://junit.org/junit5/
[Maven Central]: https://central.sonatype.com/
[ScalaDoc]: https://docs.gradle.org/current/dsl/org.gradle.api.tasks.scala.ScalaDoc.html
[Cayman]: https://hanggrian.github.io/cayman-dark-theme/
[Minimal]: https://hanggrian.github.io/minimal-dark-theme/
