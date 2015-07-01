# Flint

### What is Flint?

Flint is a cross-platform framework designed to act as a universal backend for Minecraft minigame mods, handling generic
tasks such as arena, round, and player management which would normally require a significant time investment to develop
for each minigame.

### How to use Flint

Documentation is published continuously to [http://jd.caseif.net/flint](http://jd.caseif.net/flint). Additionally, a
tutorial will be written and published upon initial release of the API.

### Prerequisites

Flint requires Java 7 for compilation and use.

### Building

Flint uses Gradle as its build system. To clone and build the plugin from scratch:

- `git clone https://github.com/caseif/Flint.git`
- `cd Flint`
- `cp scripts/* .git/hooks`
- `./gradlew` (`gradlew` or `sh ./gradlew` on Windows)

### Contribution guidelines

If you think you have a code contribution which would benefit Flint's API, feel free to create an issue or pull request.
The primary guideline for whether a contribution is acceptable is whether it is utilizable by multiple classes of
minigames. Some features (e.g. a gun API) are too high-level for the purposes of this framework and thus will not be
added.

### Implementing

Specification for those wishing to implement Flint may be found [here](resources/doc/IMPLEMENTING.MD).

### Contact

I can be contacted [via email at me@caseif.net](mailto:me@caseif.net).

### Copyright

Flint's source code and binary are provided under the BSD 3-Clause license.
