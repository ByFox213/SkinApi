# syntax = docker/dockerfile:experimental
FROM gradle:jdk17 as builder
WORKDIR /app
COPY src ./src
COPY build.gradle.kts ./build.gradle.kts
RUN --mount=type=cache,target=./.gradle gradle clean test install

FROM openjdk:17 as backend
WORKDIR /root
COPY --from=builder /app/build/install/app ./
