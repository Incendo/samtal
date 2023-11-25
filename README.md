# samtal

## what
samtal is two things:
- A collection of accurate descriptions and models of the different Discord apis
- A collection of implementations of the different apis, and connections between them - forming a Discord application library

## why
The world of JVM Discord libraries is a mess. There are many different libraries
with varying support for the Discord APIs. They either do slightly too much or slightly too little.
Samtal is our take on this, which hopefully ends up in the useful middle. An important goal is to make
command integration less painful than it currently is.

## how
The primary goal is to model the APIs that we eventually implement as closely as possible.
We try to use Discord names (even when they're objectively bad and confusing), and we add fields
and objects that we may not have an immediate use for.
The implementations of these APIs may then  only implement a sub-set of the features that Discord supports, but we then have 
the ability to either extend the existing implementations or create new implementations that are more feature-complete.

The goal is not necessarily to reinvent the wheel(s). There are certainly good parts of other libraries and when appropriate
samtal will delegate to them. For example, Discord4J has a good unopinionated implemention of Gateway that we may use. 
Incendo/cloud will be used as the command API.

## goals
The primary goals are to:
- model the HTTP API (samtal-discord)
- model the Gateway API (samtal-gateway) and have at least one implementation (samtal-gateway-d4j)
- tie the HTTP and Gateway APIs together (samtal-core)

We would also like to have mappings for the webhook API and an implementation of it.

When all of this is complete, we may then move on to other Discord features, such as voice.
