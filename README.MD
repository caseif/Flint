# Flint [![Build Status](http://ci.caseif.net/job/Flint/badge/icon)](http://ci.caseif.net/job/Flint/)

Flint is a cross-platform engine designed to act as a universal backend for Minecraft minigame mods, handling generic
tasks such as arena, round, and player management which would normally require a significant time investment to develop
for each minigame.

### How to use Flint

Documentation is published continuously to [http://jd.caseif.net/flint](http://jd.caseif.net/flint). Additionally, a
tutorial will be written and published upon initial release of the API.

### Prerequisites

Flint requires Java 7 for compilation and use.

### Building

Flint uses Gradle as its build system. To clone and build the project from scratch:

- `git clone https://github.com/caseif/Flint.git`
- `cd Flint`
- `cp scripts/* .git/hooks`
- `./gradlew` (`gradlew` or `sh ./gradlew` on Windows)

### Contribution guidelines

If you think you have a code contribution which would benefit Flint's API, feel free to create an issue or pull request.
All contributions must follow the [Flint doctrine](https://github.com/caseif/Flint/wiki/Tutorial#doctrine) where
applicable.

### Implementing

Specification for those wishing to implement Flint may be found 
[here](https://github.com/caseif/Flint/wiki/Implementation%20Specification).

### Contact

I can be contacted [via email at me@caseif.net](mailto:me@caseif.net).

### Copyright

Flint's source code and binary are provided under the BSD 3-Clause license.
