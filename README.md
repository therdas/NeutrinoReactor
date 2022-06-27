# Neutrino Reactor (Runtime)

---
This is an effort to rewrite the Neutrino runtime (previously Neutrino Core), which was earlier written in Javascript, in Kotlin. This will allow many things:

- A native android application that supports/targets the latest API version
- Moving away from NativeScript and JS environment, which leads to
- Typesafe, null-safe Kotlin Code, for better performance
- Easy migration to the Web, using Kotlin.js

However, just _rewriting_ is not the be-and-end-all of this approach. I'll also try to:

- [x] Implement the hidden flags
- [ ] Adding a timing-accuracy mode, to turn it into a proper emulator.
- [ ] Implementing the undocumented instructions to achieve full binary compatibility
- [ ] Creating a runtime that can detect infinite loops, and break as and when necessary
- [ ] Custom input/output ports (using Callbacks) that can be used in the eventual webapps and android app to emulate IO Devices
- [ ] Memory "compaction", so that we don't need the entire 64kB fully allocated in the first place
- [ ] Enabling a MVC model for applications that need to use it (Neutrino core's model directly modified the view, which is undesirable for obvious reasons)

## Contributing

---

This is supposed to be a one-man passion project, but I'll accept all the help I can get! For now

- If you want to suggest changes, either submit a PR or mail me at therealrdas@gmail.com
- If you have found a bug, logical inconsistency or indeed, any way in which the execution model differs from the real microprocessor, feel free to create an Issue!


## Compiling for your own

---

This project is still in very, _very_ early development. Think pre-pre-alpha. If you still want to build it:

- Make sure you have at least Java 1.8+, Kotlin 1.6.20+. This project will migrate to 1.7+ soon, to leverage the K2 Compiler.
- Clone the repo
- Open in IntelliJ IDEA or any other IDE OR
- Run the ./gradlew script (after giving it execution permission, of course)
- Use `gradle build` and enjoy!
