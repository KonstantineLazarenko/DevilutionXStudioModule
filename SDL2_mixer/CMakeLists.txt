
cmake_minimum_required(VERSION 3.4.1)
project(SDL2_mixer)


find_library( # Sets the name of the path variable.
        GLESv1_CM
        GLESv2
        android
        z
        log
)

include_directories(
        native_midi
        ${CMAKE_CURRENT_SOURCE_DIR}/../SDL2/include
)

add_definitions(-DGL_GLEXT_PROTOTYPES -DMUSIC_WAV)

add_library( # Sets the name of the library.
        SDL2_mixer

        # Sets the library as a shared library.
        SHARED

        effect_position.c
        effect_stereoreverse.c
        effects_internal.c
        load_aiff.c
        load_voc.c
        mixer.c
        music.c
        music_cmd.c
        music_flac.c
        music_fluidsynth.c
        music_mad.c
        music_mikmod.c
        music_modplug.c
        music_mpg123.c
        music_nativemidi.c
        music_ogg.c
        music_opus.c
        music_wav.c
        #playmus.c
        #playwave.c
        native_midi/native_midi_common.c
        )


target_link_libraries(
        SDL2_mixer
        SDL2
        GLESv1_CM
        GLESv2
        android
        z
        log
)
