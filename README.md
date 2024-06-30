![Build Status](https://github.com/Pieter-127/ModernMonsters/workflows/Build/badge.svg)

# Modern Monsters
A basic project for using some of the newer things in android, including modular architecture with buildSrc plugins, the new compose navigation library, some paging with room and setting up the adaptive navigation library.  

The app uses the paging library in combination with retrofit to make api calls and to display a list of pokemon, you can tap on a pokemon to get some more info on it, as well as to get some information on the (at this point in time) 18 types of different pokemon attributes.

I tried to keep this relatively simple, the UI can always be improved and perhaps a couple of composables could be shared amongst features if needed, the diagram for the architecture can be found [here](https://github.com/Pieter-127/ModernMonsters/blob/develop/Architecture.JPG)</br>

Essentially what I tried to achieve is to have the various different features completely seperate, so that one feature doesn't depend on another, although data can be passed between these using the compose navigation library.</br>
These features make use of core modules, such as a domain module, a data module, a design system module, etc.</br>
These core modules can also use and rely on another core modules if needed, such as for the case where the data module is made up of a network and database module.</br>

I made use of Github Actions to put together a simple build script that should also upload Apk's for the lastest build, you can find those [here](https://github.com/Pieter-127/ModernMonsters/actions)</br>

A demo of the app while running can be downloaded from [here](https://github.com/Pieter-127/ModernMonsters/blob/develop/demo.mp4)</br>
