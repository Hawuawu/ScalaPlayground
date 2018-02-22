$ sbt test
[info] Loading project definition from /Users/jancajthaml/Repositories/CreativeDocs-PRS/ScalaPlayground/project
[info] Loading settings from build.sbt ...
[info] Set current project to Hawu Scala Playground (in build file:/Users/jancajthaml/Repositories/CreativeDocs-PRS/ScalaPlayground/)
[DEBUG] [02/22/2018 13:20:17.512] [pool-5-thread-2-ScalaTest-running-CoreTests] [EventStream(akka://b704e402-60c8-4030-98a3-f77282ce4ba7)] logger log1-Logging$DefaultLogger started
[DEBUG] [02/22/2018 13:20:17.513] [pool-5-thread-2-ScalaTest-running-CoreTests] [EventStream(akka://b704e402-60c8-4030-98a3-f77282ce4ba7)] Default Loggers started
[INFO] [02/22/2018 13:20:17.590] [b704e402-60c8-4030-98a3-f77282ce4ba7-akka.actor.default-dispatcher-2] [akka.persistence.Persistence(akka://b704e402-60c8-4030-98a3-f77282ce4ba7)] Auto-starting journal plugin `akka.persistence.journal.leveldb`
[DEBUG] [02/22/2018 13:20:17.593] [b704e402-60c8-4030-98a3-f77282ce4ba7-akka.actor.default-dispatcher-2] [akka.persistence.Persistence(akka://b704e402-60c8-4030-98a3-f77282ce4ba7)] Create plugin: akka.persistence.journal.leveldb akka.persistence.journal.leveldb.LeveldbJournal
[INFO] [02/22/2018 13:20:17.651] [b704e402-60c8-4030-98a3-f77282ce4ba7-akka.actor.default-dispatcher-2] [akka.persistence.Persistence(akka://b704e402-60c8-4030-98a3-f77282ce4ba7)] Auto-starting snapshot store `akka.persistence.snapshot-store.local`
[DEBUG] [02/22/2018 13:20:17.651] [b704e402-60c8-4030-98a3-f77282ce4ba7-akka.actor.default-dispatcher-2] [akka.persistence.Persistence(akka://b704e402-60c8-4030-98a3-f77282ce4ba7)] Create plugin: akka.persistence.snapshot-store.local akka.persistence.snapshot.local.LocalSnapshotStore
Uncaught error from thread [b704e402-60c8-4030-98a3-f77282ce4ba7-akka.persistence.dispatchers.default-plugin-dispatcher-11]: org/iq80/leveldb/impl/Iq80DBFactory, shutting down JVM since 'akka.jvm-exit-on-fatal-error' is enabled for ActorSystem[b704e402-60c8-4030-98a3-f77282ce4ba7]
java.lang.NoClassDefFoundError: org/iq80/leveldb/impl/Iq80DBFactory
  at akka.persistence.journal.leveldb.LeveldbStore.leveldbFactory(LeveldbStore.scala:59)
  at akka.persistence.journal.leveldb.LeveldbStore.leveldbFactory$(LeveldbStore.scala:57)
  at akka.persistence.journal.leveldb.LeveldbJournal.leveldbFactory(LeveldbJournal.scala:23)
  at akka.persistence.journal.leveldb.LeveldbStore.preStart(LeveldbStore.scala:186)
  at akka.persistence.journal.leveldb.LeveldbStore.preStart$(LeveldbStore.scala:185)
  at akka.persistence.journal.leveldb.LeveldbJournal.preStart(LeveldbJournal.scala:23)
  at akka.actor.Actor.aroundPreStart(Actor.scala:528)
  at akka.actor.Actor.aroundPreStart$(Actor.scala:528)
  at akka.persistence.journal.leveldb.LeveldbJournal.aroundPreStart(LeveldbJournal.scala:23)
  at akka.actor.ActorCell.create(ActorCell.scala:591)
  at akka.actor.ActorCell.invokeAll$1(ActorCell.scala:462)
  at akka.actor.ActorCell.systemInvoke(ActorCell.scala:484)
  at akka.dispatch.Mailbox.processAllSystemMessages(Mailbox.scala:282)
  at akka.dispatch.Mailbox.run(Mailbox.scala:223)
  at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
  at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
  at java.lang.Thread.run(Thread.java:745)
Caused by: java.lang.ClassNotFoundException: org.iq80.leveldb.impl.Iq80DBFactory
  at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
  at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
  at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
  ... 17 more
[ERROR] [SECURITY][02/22/2018 13:20:17.745] [b704e402-60c8-4030-98a3-f77282ce4ba7-akka.persistence.dispatchers.default-plugin-dispatcher-11] [akka.actor.ActorSystemImpl(b704e402-60c8-4030-98a3-f77282ce4ba7)] Uncaught error from thread [b704e402-60c8-4030-98a3-f77282ce4ba7-akka.persistence.dispatchers.default-plugin-dispatcher-11]: org/iq80/leveldb/impl/Iq80DBFactory, shutting down JVM since 'akka.jvm-exit-on-fatal-error' is enabled for ActorSystem[b704e402-60c8-4030-98a3-f77282ce4ba7]
java.lang.NoClassDefFoundError: org/iq80/leveldb/impl/Iq80DBFactory
  at akka.persistence.journal.leveldb.LeveldbStore.leveldbFactory(LeveldbStore.scala:59)
  at akka.persistence.journal.leveldb.LeveldbStore.leveldbFactory$(LeveldbStore.scala:57)
  at akka.persistence.journal.leveldb.LeveldbJournal.leveldbFactory(LeveldbJournal.scala:23)
  at akka.persistence.journal.leveldb.LeveldbStore.preStart(LeveldbStore.scala:186)
  at akka.persistence.journal.leveldb.LeveldbStore.preStart$(LeveldbStore.scala:185)
  at akka.persistence.journal.leveldb.LeveldbJournal.preStart(LeveldbJournal.scala:23)
  at akka.actor.Actor.aroundPreStart(Actor.scala:528)
  at akka.actor.Actor.aroundPreStart$(Actor.scala:528)
  at akka.persistence.journal.leveldb.LeveldbJournal.aroundPreStart(LeveldbJournal.scala:23)
  at akka.actor.ActorCell.create(ActorCell.scala:591)
  at akka.actor.ActorCell.invokeAll$1(ActorCell.scala:462)
  at akka.actor.ActorCell.systemInvoke(ActorCell.scala:484)
  at akka.dispatch.Mailbox.processAllSystemMessages(Mailbox.scala:282)
  at akka.dispatch.Mailbox.run(Mailbox.scala:223)
  at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
  at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
  at java.lang.Thread.run(Thread.java:745)
Caused by: java.lang.ClassNotFoundException: org.iq80.leveldb.impl.Iq80DBFactory
  at java.net.URLClassLoader.findClass(URLClassLoader.java:381)
  at java.lang.ClassLoader.loadClass(ClassLoader.java:424)
  at java.lang.ClassLoader.loadClass(ClassLoader.java:357)
  ... 17 more

[DEBUG] [02/22/2018 13:20:17.746] [b704e402-60c8-4030-98a3-f77282ce4ba7-shutdown-hook-1] [CoordinatedShutdown(akka://b704e402-60c8-4030-98a3-f77282ce4ba7)] Starting coordinated shutdown from JVM shutdown hook
[DEBUG] [02/22/2018 13:20:17.748] [b704e402-60c8-4030-98a3-f77282ce4ba7-shutdown-hook-1] [CoordinatedShutdown(akka://b704e402-60c8-4030-98a3-f77282ce4ba7)] Performing phase [before-service-unbind] with [0] tasks
[DEBUG] [02/22/2018 13:20:17.776] [b704e402-60c8-4030-98a3-f77282ce4ba7-akka.actor.default-dispatcher-2] [CoordinatedShutdown(akka://b704e402-60c8-4030-98a3-f77282ce4ba7)] Performing phase [service-unbind] with [0] tasks
[DEBUG] [02/22/2018 13:20:17.776] [b704e402-60c8-4030-98a3-f77282ce4ba7-akka.actor.default-dispatcher-2] [CoordinatedShutdown(akka://b704e402-60c8-4030-98a3-f77282ce4ba7)] Performing phase [service-requests-done] with [0] tasks
[DEBUG] [02/22/2018 13:20:17.776] [b704e402-60c8-4030-98a3-f77282ce4ba7-akka.actor.default-dispatcher-2] [CoordinatedShutdown(akka://b704e402-60c8-4030-98a3-f77282ce4ba7)] Performing phase [service-stop] with [0] tasks
[DEBUG] [02/22/2018 13:20:17.776] [b704e402-60c8-4030-98a3-f77282ce4ba7-akka.actor.default-dispatcher-2] [CoordinatedShutdown(akka://b704e402-60c8-4030-98a3-f77282ce4ba7)] Performing phase [before-cluster-shutdown] with [0] tasks
[DEBUG] [02/22/2018 13:20:17.776] [b704e402-60c8-4030-98a3-f77282ce4ba7-akka.actor.default-dispatcher-2] [CoordinatedShutdown(akka://b704e402-60c8-4030-98a3-f77282ce4ba7)] Performing phase [cluster-sharding-shutdown-region] with [0] tasks
[DEBUG] [02/22/2018 13:20:17.776] [b704e402-60c8-4030-98a3-f77282ce4ba7-akka.actor.default-dispatcher-2] [CoordinatedShutdown(akka://b704e402-60c8-4030-98a3-f77282ce4ba7)] Performing phase [cluster-leave] with [0] tasks
[DEBUG] [02/22/2018 13:20:17.776] [b704e402-60c8-4030-98a3-f77282ce4ba7-akka.actor.default-dispatcher-2] [CoordinatedShutdown(akka://b704e402-60c8-4030-98a3-f77282ce4ba7)] Performing phase [cluster-exiting] with [0] tasks
[DEBUG] [02/22/2018 13:20:17.777] [b704e402-60c8-4030-98a3-f77282ce4ba7-akka.actor.default-dispatcher-2] [CoordinatedShutdown(akka://b704e402-60c8-4030-98a3-f77282ce4ba7)] Performing phase [cluster-exiting-done] with [0] tasks
[DEBUG] [02/22/2018 13:20:17.778] [b704e402-60c8-4030-98a3-f77282ce4ba7-akka.actor.default-dispatcher-2] [CoordinatedShutdown(akka://b704e402-60c8-4030-98a3-f77282ce4ba7)] Performing phase [cluster-shutdown] with [0] tasks
[DEBUG] [02/22/2018 13:20:17.778] [b704e402-60c8-4030-98a3-f77282ce4ba7-akka.actor.default-dispatcher-2] [CoordinatedShutdown(akka://b704e402-60c8-4030-98a3-f77282ce4ba7)] Performing phase [before-actor-system-terminate] with [0] tasks
[DEBUG] [02/22/2018 13:20:17.779] [b704e402-60c8-4030-98a3-f77282ce4ba7-akka.actor.default-dispatcher-2] [CoordinatedShutdown(akka://b704e402-60c8-4030-98a3-f77282ce4ba7)] Performing phase [actor-system-terminate] with [1] tasks: [terminate-system]
[DEBUG] [02/22/2018 13:20:17.799] [b704e402-60c8-4030-98a3-f77282ce4ba7-akka.actor.default-dispatcher-9] [akka://b704e402-60c8-4030-98a3-f77282ce4ba7/user/playgroundState] Stopping actor and storing snapshot
[INFO] [02/22/2018 13:20:17.808] [b704e402-60c8-4030-98a3-f77282ce4ba7-akka.actor.default-dispatcher-10] [akka://b704e402-60c8-4030-98a3-f77282ce4ba7/user/playgroundState] Message [com.hawu.scala.playground.persistence.GetActualState$] from Actor[akka://b704e402-60c8-4030-98a3-f77282ce4ba7/user/commandHandler/$a#446256638] to Actor[akka://b704e402-60c8-4030-98a3-f77282ce4ba7/user/playgroundState#1177141188] was not delivered. [1] dead letters encountered. This logging can be turned off or adjusted with configuration settings 'akka.log-dead-letters' and 'akka.log-dead-letters-during-shutdown'.
[INFO] [02/22/2018 13:20:17.809] [b704e402-60c8-4030-98a3-f77282ce4ba7-akka.actor.default-dispatcher-10] [akka://b704e402-60c8-4030-98a3-f77282ce4ba7/user/playgroundState] Message [com.hawu.scala.playground.persistence.GetActualState$] from Actor[akka://b704e402-60c8-4030-98a3-f77282ce4ba7/user/commandHandler/$b#-1128845368] to Actor[akka://b704e402-60c8-4030-98a3-f77282ce4ba7/user/playgroundState#1177141188] was not delivered. [2] dead letters encountered. This logging can be turned off or adjusted with configuration settings 'akka.log-dead-letters' and 'akka.log-dead-letters-during-shutdown'.
[INFO] [02/22/2018 13:20:17.809] [b704e402-60c8-4030-98a3-f77282ce4ba7-akka.actor.default-dispatcher-10] [akka://b704e402-60c8-4030-98a3-f77282ce4ba7/user/playgroundState] Message [com.hawu.scala.playground.persistence.GetActualState$] from Actor[akka://b704e402-60c8-4030-98a3-f77282ce4ba7/user/commandHandler/$c#-1583981793] to Actor[akka://b704e402-60c8-4030-98a3-f77282ce4ba7/user/playgroundState#1177141188] was not delivered. [3] dead letters encountered. This logging can be turned off or adjusted with configuration settings 'akka.log-dead-letters' and 'akka.log-dead-letters-during-shutdown'.
[INFO] [02/22/2018 13:20:17.809] [b704e402-60c8-4030-98a3-f77282ce4ba7-akka.actor.default-dispatcher-10] [akka://b704e402-60c8-4030-98a3-f77282ce4ba7/user/playgroundState] Message [com.hawu.scala.playground.persistence.GetActualState$] from Actor[akka://b704e402-60c8-4030-98a3-f77282ce4ba7/user/commandHandler/$d#1017681718] to Actor[akka://b704e402-60c8-4030-98a3-f77282ce4ba7/user/playgroundState#1177141188] was not delivered. [4] dead letters encountered. This logging can be turned off or adjusted with configuration settings 'akka.log-dead-letters' and 'akka.log-dead-letters-during-shutdown'.
[INFO] [02/22/2018 13:20:17.809] [b704e402-60c8-4030-98a3-f77282ce4ba7-akka.actor.default-dispatcher-10] [akka://b704e402-60c8-4030-98a3-f77282ce4ba7/user/playgroundState] Message [com.hawu.scala.playground.persistence.GetActualState$] from Actor[akka://b704e402-60c8-4030-98a3-f77282ce4ba7/user/commandHandler/$e#-1226611356] to Actor[akka://b704e402-60c8-4030-98a3-f77282ce4ba7/user/playgroundState#1177141188] was not delivered. [5] dead letters encountered. This logging can be turned off or adjusted with configuration settings 'akka.log-dead-letters' and 'akka.log-dead-letters-during-shutdown'.
[INFO] [02/22/2018 13:20:17.809] [b704e402-60c8-4030-98a3-f77282ce4ba7-akka.actor.default-dispatcher-10] [akka://b704e402-60c8-4030-98a3-f77282ce4ba7/user/playgroundState] Message [com.hawu.scala.playground.persistence.GetActualState$] from Actor[akka://b704e402-60c8-4030-98a3-f77282ce4ba7/user/commandHandler/$f#-1014174427] to Actor[akka://b704e402-60c8-4030-98a3-f77282ce4ba7/user/playgroundState#1177141188] was not delivered. [6] dead letters encountered. This logging can be turned off or adjusted with configuration settings 'akka.log-dead-letters' and 'akka.log-dead-letters-during-shutdown'.
[INFO] [02/22/2018 13:20:17.810] [b704e402-60c8-4030-98a3-f77282ce4ba7-akka.actor.default-dispatcher-10] [akka://b704e402-60c8-4030-98a3-f77282ce4ba7/user/playgroundState] Message [com.hawu.scala.playground.persistence.GetActualState$] from Actor[akka://b704e402-60c8-4030-98a3-f77282ce4ba7/user/commandHandler/$g#-1028613835] to Actor[akka://b704e402-60c8-4030-98a3-f77282ce4ba7/user/playgroundState#1177141188] was not delivered. [7] dead letters encountered. This logging can be turned off or adjusted with configuration settings 'akka.log-dead-letters' and 'akka.log-dead-letters-during-shutdown'.
[INFO] [02/22/2018 13:20:17.811] [b704e402-60c8-4030-98a3-f77282ce4ba7-akka.actor.default-dispatcher-10] [akka://b704e402-60c8-4030-98a3-f77282ce4ba7/user/playgroundState] Message [com.hawu.scala.playground.persistence.GetActualState$] from Actor[akka://b704e402-60c8-4030-98a3-f77282ce4ba7/user/commandHandler/$h#972064667] to Actor[akka://b704e402-60c8-4030-98a3-f77282ce4ba7/user/playgroundState#1177141188] was not delivered. [8] dead letters encountered. This logging can be turned off or adjusted with configuration settings 'akka.log-dead-letters' and 'akka.log-dead-letters-during-shutdown'.
[INFO] [02/22/2018 13:20:17.811] [b704e402-60c8-4030-98a3-f77282ce4ba7-akka.actor.default-dispatcher-10] [akka://b704e402-60c8-4030-98a3-f77282ce4ba7/user/playgroundState] Message [com.hawu.scala.playground.persistence.GetActualState$] from Actor[akka://b704e402-60c8-4030-98a3-f77282ce4ba7/user/commandHandler/$i#-1923152887] to Actor[akka://b704e402-60c8-4030-98a3-f77282ce4ba7/user/playgroundState#1177141188] was not delivered. [9] dead letters encountered. This logging can be turned off or adjusted with configuration settings 'akka.log-dead-letters' and 'akka.log-dead-letters-during-shutdown'.
[INFO] [02/22/2018 13:20:17.811] [b704e402-60c8-4030-98a3-f77282ce4ba7-akka.actor.default-dispatcher-10] [akka://b704e402-60c8-4030-98a3-f77282ce4ba7/user/playgroundState] Message [com.hawu.scala.playground.persistence.GetActualState$] from Actor[akka://b704e402-60c8-4030-98a3-f77282ce4ba7/user/commandHandler/$j#-139610770] to Actor[akka://b704e402-60c8-4030-98a3-f77282ce4ba7/user/playgroundState#1177141188] was not delivered. [10] dead letters encountered, no more dead letters will be logged. This logging can be turned off or adjusted with configuration settings 'akka.log-dead-letters' and 'akka.log-dead-letters-during-shutdown'.
[DEBUG] [02/22/2018 13:20:17.822] [b704e402-60c8-4030-98a3-f77282ce4ba7-akka.actor.default-dispatcher-5] [EventStream] shutting down: StandardOutLogger started
[ERROR] [02/22/2018 13:20:17.826] [b704e402-60c8-4030-98a3-f77282ce4ba7-akka.persistence.dispatchers.default-plugin-dispatcher-13] [akka://b704e402-60c8-4030-98a3-f77282ce4ba7/system/akka.persistence.journal.leveldb] null
java.lang.NullPointerException
  at akka.persistence.journal.leveldb.LeveldbStore.postStop(LeveldbStore.scala:191)
  at akka.persistence.journal.leveldb.LeveldbStore.postStop$(LeveldbStore.scala:190)
  at akka.persistence.journal.leveldb.LeveldbJournal.postStop(LeveldbJournal.scala:23)
  at akka.actor.Actor.aroundPostStop(Actor.scala:536)
  at akka.actor.Actor.aroundPostStop$(Actor.scala:536)
  at akka.persistence.journal.leveldb.LeveldbJournal.aroundPostStop(LeveldbJournal.scala:23)
  at akka.actor.dungeon.FaultHandling.finishTerminate(FaultHandling.scala:210)
  at akka.actor.dungeon.FaultHandling.handleChildTerminated(FaultHandling.scala:293)
  at akka.actor.dungeon.FaultHandling.handleChildTerminated$(FaultHandling.scala:272)
  at akka.actor.ActorCell.handleChildTerminated(ActorCell.scala:370)
  at akka.actor.dungeon.DeathWatch.watchedActorTerminated(DeathWatch.scala:80)
  at akka.actor.dungeon.DeathWatch.watchedActorTerminated$(DeathWatch.scala:68)
  at akka.actor.ActorCell.watchedActorTerminated(ActorCell.scala:370)
  at akka.actor.ActorCell.invokeAll$1(ActorCell.scala:461)
  at akka.actor.ActorCell.systemInvoke(ActorCell.scala:484)
  at akka.dispatch.Mailbox.processAllSystemMessages(Mailbox.scala:282)
  at akka.dispatch.Mailbox.run(Mailbox.scala:223)
  at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
  at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
  at java.lang.Thread.run(Thread.java:745)

