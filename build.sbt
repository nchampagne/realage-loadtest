val projectName = "realage-loadtest"

val settings = Seq(
  organization  := "com.sharecare",
  name          := projectName,
  version       := "1.0.0-SNAPSHOT",
  description   := "RealAge load test application",
  scalaVersion  := "2.12.3",

  trapExit      := false,

  cleanFiles <+= target { dir => dir / "universal" },

  mainClass in Compile := Some("com.sharecare.Main"),

  resolvers ++= Resolver.jcenterRepo +: Resolver.bintrayRepo("scalaz", "releases") +: {
    val artifactory = "https://artifactory.be.sharecare.com"

    Seq(
      "Sonatype OSS Snapshots"              at "https://oss.sonatype.org/content/repositories/snapshots",
      "Typesafe Repository"                 at "http://repo.typesafe.com/typesafe/releases/",
      "Sharecare Artifactory"               at s"$artifactory/repo",
      "Sharecare Artifactory Snapshots"     at s"$artifactory/JAM-snapshot-local/",
      "Sharecare Artifactory Releases"      at s"$artifactory/JAM-release-local/",
      "Sharecare Artifactory Lib Snapshots" at s"$artifactory/libs-snapshot/",
      "Sharecare Artifactory Lib Release"   at s"$artifactory/libs-release/"
    )
  },

  libraryDependencies ++= Seq(
//    "org.reactivemongo" %% "reactivemongo"        % "0.12.6",
    "com.typesafe.akka" %% "akka-stream"          % "2.5.4",
    "com.typesafe.akka" %% "akka-actor"           % "2.5.4",
//    "de.knutwalker"     %% "akka-stream-json"     % "3.3.0",
//    "de.knutwalker"     %% "akka-http-json"       % "3.3.0",
//    "com.typesafe.play" %% "play-json"            % "2.6.3",
    "com.typesafe.play" %% "play-ahc-ws-standalone"              % "1.1.0",
    "com.typesafe.play" %% "play-ws-standalone-json"  % "1.1.0",
//    "org.spire-math"    %% "jawn-play"            % "0.11.0",
//    "ch.qos.logback"    % "logback-classic"       % "1.2.3",
    "com.typesafe.akka" %% "akka-stream-testkit"  % "2.5.4"   % Test
  )
)

val root = Project(id = projectName, base = file("."))
  .settings(settings)
