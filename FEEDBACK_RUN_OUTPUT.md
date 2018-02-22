$ sbt run
[info] Loading project definition from /Users/jancajthaml/Repositories/CreativeDocs-PRS/ScalaPlayground/project
[info] Loading settings from build.sbt ...
[info] Set current project to Hawu Scala Playground (in build file:/Users/jancajthaml/Repositories/CreativeDocs-PRS/ScalaPlayground/)
[info] Packaging /Users/jancajthaml/Repositories/CreativeDocs-PRS/ScalaPlayground/target/scala-2.12/hawu-scala-playground_2.12-1.0.jar ...
[info] Done packaging.
[info] Running com.hawu.scala.playground.Main
[debug] Waiting for threads to exit or System.exit to be called.
[debug]   Classpath:
[debug]   /var/folders/gh/6w0t0p6x4456cxtkk3shyk3m0000gn/T/sbt_1e3823a9/job-1/target/eb9be6b0/hawu-scala-playground_2.12-1.0.jar
[debug]   /var/folders/gh/6w0t0p6x4456cxtkk3shyk3m0000gn/T/sbt_1e3823a9/target/7663f74e/scala-library.jar
[debug]   /var/folders/gh/6w0t0p6x4456cxtkk3shyk3m0000gn/T/sbt_1e3823a9/target/b6dc6f63/akka-actor_2.12-2.5.9.jar
[debug]   /var/folders/gh/6w0t0p6x4456cxtkk3shyk3m0000gn/T/sbt_1e3823a9/target/d6ac0ce0/config-1.3.2.jar
[debug]   /var/folders/gh/6w0t0p6x4456cxtkk3shyk3m0000gn/T/sbt_1e3823a9/target/1e6f1e74/scala-java8-compat_2.12-0.8.0.jar
[debug]   /var/folders/gh/6w0t0p6x4456cxtkk3shyk3m0000gn/T/sbt_1e3823a9/target/9117189e/akka-persistence_2.12-2.5.9.jar
[debug]   /var/folders/gh/6w0t0p6x4456cxtkk3shyk3m0000gn/T/sbt_1e3823a9/target/90148021/akka-protobuf_2.12-2.5.9.jar
[debug]   /var/folders/gh/6w0t0p6x4456cxtkk3shyk3m0000gn/T/sbt_1e3823a9/target/707350a2/leveldbjni-all-1.8.jar
[debug]   /var/folders/gh/6w0t0p6x4456cxtkk3shyk3m0000gn/T/sbt_1e3823a9/target/e75f0f9c/scalactic_2.12-3.0.4.jar
[debug]   /var/folders/gh/6w0t0p6x4456cxtkk3shyk3m0000gn/T/sbt_1e3823a9/target/2df9e601/scala-reflect.jar
[debug]   /var/folders/gh/6w0t0p6x4456cxtkk3shyk3m0000gn/T/sbt_1e3823a9/target/b6dde383/commons-io-1.3.2.jar
[debug] Waiting for thread run-main-0 to terminate.
[DEBUG] [02/22/2018 13:21:06.010] [run-main-0] [EventStream(akka://Hawus_space)] logger log1-Logging$DefaultLogger started
[DEBUG] [02/22/2018 13:21:06.011] [run-main-0] [EventStream(akka://Hawus_space)] Default Loggers started
[DEBUG] [02/22/2018 13:21:06.119] [run-main-0] [akka.actor.ActorSystemImpl(Hawus_space)] Press enter to quit!
[INFO] [02/22/2018 13:21:06.126] [Hawus_space-akka.actor.default-dispatcher-3] [akka.persistence.Persistence(akka://Hawus_space)] Auto-starting journal plugin `akka.persistence.journal.leveldb`
[DEBUG] [02/22/2018 13:21:06.129] [Hawus_space-akka.actor.default-dispatcher-3] [akka.persistence.Persistence(akka://Hawus_space)] Create plugin: akka.persistence.journal.leveldb akka.persistence.journal.leveldb.LeveldbJournal
[INFO] [02/22/2018 13:21:06.162] [Hawus_space-akka.actor.default-dispatcher-3] [akka.persistence.Persistence(akka://Hawus_space)] Auto-starting snapshot store `akka.persistence.snapshot-store.local`
[DEBUG] [02/22/2018 13:21:06.162] [Hawus_space-akka.actor.default-dispatcher-3] [akka.persistence.Persistence(akka://Hawus_space)] Create plugin: akka.persistence.snapshot-store.local akka.persistence.snapshot.local.LocalSnapshotStore
Uncaught error from thread [Hawus_space-akka.persistence.dispatchers.default-plugin-dispatcher-6]: org/iq80/leveldb/impl/Iq80DBFactory, shutting down JVM since 'akka.jvm-exit-on-fatal-error' is enabled for ActorSystem[Hawus_space]
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
[ERROR] [SECURITY][02/22/2018 13:21:06.228] [Hawus_space-akka.persistence.dispatchers.default-plugin-dispatcher-6] [akka.actor.ActorSystemImpl(Hawus_space)] Uncaught error from thread [Hawus_space-akka.persistence.dispatchers.default-plugin-dispatcher-6]: org/iq80/leveldb/impl/Iq80DBFactory, shutting down JVM since 'akka.jvm-exit-on-fatal-error' is enabled for ActorSystem[Hawus_space]
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

[debug] Interrupting thread Hawus_space-akka.actor.default-dispatcher-3
[debug]   Interrupted Hawus_space-akka.actor.default-dispatcher-3
[debug] Interrupting thread Hawus_space-akka.persistence.dispatchers.default-plugin-dispatcher-7
[debug]   Interrupted Hawus_space-akka.persistence.dispatchers.default-plugin-dispatcher-7
[debug] Interrupting thread Hawus_space-akka.persistence.dispatchers.default-plugin-dispatcher-6
[debug]   Interrupted Hawus_space-akka.persistence.dispatchers.default-plugin-dispatcher-6
[debug] Interrupting thread Hawus_space-akka.actor.default-dispatcher-5
[debug]   Interrupted Hawus_space-akka.actor.default-dispatcher-5
[debug] Interrupting thread Hawus_space-scheduler-1
[debug]   Interrupted Hawus_space-scheduler-1
[debug] Interrupting thread Hawus_space-akka.actor.default-dispatcher-2
[debug]   Interrupted Hawus_space-akka.actor.default-dispatcher-2
[debug] Interrupting thread Hawus_space-akka.actor.default-dispatcher-4
[debug]   Interrupted Hawus_space-akka.actor.default-dispatcher-4
[debug] Interrupting thread run-main-0
[debug]   Interrupted run-main-0
[debug] Interrupting thread Hawus_space-shutdown-hook-1
[debug]   Interrupted Hawus_space-shutdown-hook-1
[debug] Interrupting thread Hawus_space-akka.persistence.dispatchers.default-plugin-dispatcher-8
[debug]   Interrupted Hawus_space-akka.persistence.dispatchers.default-plugin-dispatcher-8

Exception: sbt.TrapExitSecurityException thrown from the UncaughtExceptionHandler in thread "Hawus_space-akka.persistence.dispatchers.default-plugin-dispatcher-6"
[ERROR] [02/22/2018 13:21:06.290] [Hawus_space-akka.actor.default-dispatcher-5] [akka://Hawus_space/user/playgroundState] Persistence failure when replaying events for persistenceId [persistence-state-1]. Last known sequence number [0]
java.lang.NullPointerException
  at akka.persistence.journal.leveldb.LeveldbIdMapping.writeIdMapping(LeveldbIdMapping.scala:65)
  at akka.persistence.journal.leveldb.LeveldbIdMapping.numericId(LeveldbIdMapping.scala:34)
  at akka.persistence.journal.leveldb.LeveldbIdMapping.numericId$(LeveldbIdMapping.scala:32)
  at akka.persistence.journal.leveldb.LeveldbJournal.numericId(LeveldbJournal.scala:23)
  at akka.persistence.journal.leveldb.LeveldbRecovery.asyncReadHighestSequenceNr(LeveldbRecovery.scala:26)
  at akka.persistence.journal.leveldb.LeveldbRecovery.asyncReadHighestSequenceNr$(LeveldbRecovery.scala:25)
  at akka.persistence.journal.leveldb.LeveldbJournal.asyncReadHighestSequenceNr(LeveldbJournal.scala:23)
  at akka.persistence.journal.AsyncWriteJournal$$anonfun$receiveWriteJournal$1.$anonfun$applyOrElse$13(AsyncWriteJournal.scala:133)
  at akka.pattern.CircuitBreaker$State.materialize$1(CircuitBreaker.scala:685)
  at akka.pattern.CircuitBreaker$State.callThrough(CircuitBreaker.scala:722)
  at akka.pattern.CircuitBreaker$State.callThrough$(CircuitBreaker.scala:683)
  at akka.pattern.CircuitBreaker$Closed$.callThrough(CircuitBreaker.scala:794)
  at akka.pattern.CircuitBreaker$Closed$.invoke(CircuitBreaker.scala:803)
  at akka.pattern.CircuitBreaker.withCircuitBreaker(CircuitBreaker.scala:199)
  at akka.persistence.journal.AsyncWriteJournal$$anonfun$receiveWriteJournal$1.applyOrElse(AsyncWriteJournal.scala:133)
  at scala.PartialFunction$OrElse.applyOrElse(PartialFunction.scala:171)
  at akka.actor.Actor.aroundReceive(Actor.scala:517)
  at akka.actor.Actor.aroundReceive$(Actor.scala:515)
  at akka.persistence.journal.leveldb.LeveldbJournal.aroundReceive(LeveldbJournal.scala:23)
  at akka.actor.ActorCell.receiveMessage(ActorCell.scala:527)
  at akka.actor.ActorCell.invoke(ActorCell.scala:496)
  at akka.dispatch.Mailbox.processMailbox(Mailbox.scala:257)
  at akka.dispatch.Mailbox.run(Mailbox.scala:224)
  at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
  at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
  at java.lang.Thread.run(Thread.java:745)

[DEBUG] [02/22/2018 13:21:06.295] [Hawus_space-akka.actor.default-dispatcher-5] [akka://Hawus_space/user/playgroundState] Stopping actor and storing snapshot
[INFO] [02/22/2018 13:21:06.300] [Hawus_space-akka.actor.default-dispatcher-4] [akka://Hawus_space/user/playgroundState] Message [com.hawu.scala.playground.persistence.GetActualState$] from Actor[akka://Hawus_space/user/commandHandler/$a#1398593015] to Actor[akka://Hawus_space/user/playgroundState#-948187189] was not delivered. [1] dead letters encountered. This logging can be turned off or adjusted with configuration settings 'akka.log-dead-letters' and 'akka.log-dead-letters-during-shutdown'.
[WARN] [SECURITY][02/22/2018 13:21:06.306] [Hawus_space-akka.persistence.dispatchers.default-stream-dispatcher-9] [akka.serialization.Serialization(akka://Hawus_space)] Using the default Java serializer for class [com.hawu.scala.playground.persistence.PlaygroundState$Content] which is not recommended because of performance implications. Use another serializer or disable this warning using the setting 'akka.actor.warn-about-java-serializer-usage'
[DEBUG] [02/22/2018 13:21:06.306] [Hawus_space-akka.persistence.dispatchers.default-stream-dispatcher-9] [akka.serialization.Serialization(akka://Hawus_space)] Using serializer [akka.serialization.JavaSerializer] for message [com.hawu.scala.playground.persistence.PlaygroundState$Content]
[INFO] [02/22/2018 13:21:06.321] [Hawus_space-akka.actor.default-dispatcher-3] [akka://Hawus_space/user/playgroundState] Message [akka.persistence.SaveSnapshotSuccess] from Actor[akka://Hawus_space/system/akka.persistence.snapshot-store.local#1665063398] to Actor[akka://Hawus_space/user/playgroundState#-948187189] was not delivered. [2] dead letters encountered. This logging can be turned off or adjusted with configuration settings 'akka.log-dead-letters' and 'akka.log-dead-letters-during-shutdown'.
q^C[DEBUG] [02/22/2018 13:21:32.590] [Hawus_space-shutdown-hook-1] [CoordinatedShutdown(akka://Hawus_space)] Starting coordinated shutdown from JVM shutdown hook
[DEBUG] [02/22/2018 13:21:32.592] [Hawus_space-shutdown-hook-1] [CoordinatedShutdown(akka://Hawus_space)] Performing phase [before-service-unbind] with [0] tasks
[DEBUG] [02/22/2018 13:21:32.595] [Hawus_space-akka.actor.default-dispatcher-3] [CoordinatedShutdown(akka://Hawus_space)] Performing phase [service-unbind] with [0] tasks
[DEBUG] [02/22/2018 13:21:32.595] [Hawus_space-akka.actor.default-dispatcher-3] [CoordinatedShutdown(akka://Hawus_space)] Performing phase [service-requests-done] with [0] tasks
[DEBUG] [02/22/2018 13:21:32.595] [Hawus_space-akka.actor.default-dispatcher-3] [CoordinatedShutdown(akka://Hawus_space)] Performing phase [service-stop] with [0] tasks
[DEBUG] [02/22/2018 13:21:32.595] [Hawus_space-akka.actor.default-dispatcher-3] [CoordinatedShutdown(akka://Hawus_space)] Performing phase [before-cluster-shutdown] with [0] tasks
[DEBUG] [02/22/2018 13:21:32.595] [Hawus_space-akka.actor.default-dispatcher-3] [CoordinatedShutdown(akka://Hawus_space)] Performing phase [cluster-sharding-shutdown-region] with [0] tasks
[DEBUG] [02/22/2018 13:21:32.595] [Hawus_space-akka.actor.default-dispatcher-3] [CoordinatedShutdown(akka://Hawus_space)] Performing phase [cluster-leave] with [0] tasks
[DEBUG] [02/22/2018 13:21:32.595] [Hawus_space-akka.actor.default-dispatcher-3] [CoordinatedShutdown(akka://Hawus_space)] Performing phase [cluster-exiting] with [0] tasks
[DEBUG] [02/22/2018 13:21:32.595] [Hawus_space-akka.actor.default-dispatcher-3] [CoordinatedShutdown(akka://Hawus_space)] Performing phase [cluster-exiting-done] with [0] tasks
[DEBUG] [02/22/2018 13:21:32.595] [Hawus_space-akka.actor.default-dispatcher-3] [CoordinatedShutdown(akka://Hawus_space)] Performing phase [cluster-shutdown] with [0] tasks
[DEBUG] [02/22/2018 13:21:32.595] [Hawus_space-akka.actor.default-dispatcher-3] [CoordinatedShutdown(akka://Hawus_space)] Performing phase [before-actor-system-terminate] with [0] tasks
[DEBUG] [02/22/2018 13:21:32.596] [Hawus_space-akka.actor.default-dispatcher-3] [CoordinatedShutdown(akka://Hawus_space)] Performing phase [actor-system-terminate] with [1] tasks: [terminate-system]
[DEBUG] [02/22/2018 13:21:32.611] [Hawus_space-akka.actor.default-dispatcher-5] [EventStream] shutting down: StandardOutLogger started
[ERROR] [02/22/2018 13:21:32.618] [Hawus_space-akka.persistence.dispatchers.default-plugin-dispatcher-8] [akka://Hawus_space/system/akka.persistence.journal.leveldb] null
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
