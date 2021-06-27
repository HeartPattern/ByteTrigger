package io.github.ReadyMadeProgrammer.ByteTrigger.Parser

typealias StringPair = Pair<String, String>

fun cut(original: String, offset: Int): StringPair =
        when {
            offset < 0 -> Pair(original, "")
            offset >= original.length -> Pair(original, "")
            else -> Pair(original.substring(0, offset), original.substring(offset + 1, original.length))
        }

fun cutAndTrim(original: String, offset: Int): StringPair =
        when {
            offset < 0 || offset >= original.length -> Pair(original, "")
            else -> Pair(original.substring(0, offset).trim(), original.substring(offset + 1, original.length).trim())
        }

fun sliceAfter(original: String, offset: Int): StringPair =
        when {
            offset < 0 || offset >= original.length -> Pair(original, "")
            else -> Pair(original.substring(0, offset + 1), original.substring(offset + 1, original.length))
        }

fun sliceAfterAndTrim(original: String, offset: Int): StringPair =
        when {
            offset < 0 || offset >= original.length -> Pair(original, "")
            else -> Pair(original.substring(0, offset + 1).trim(), original.substring(offset + 1, original.length).trim())
        }

fun sliceBefore(original: String, offset: Int): StringPair = sliceAfter(original, offset - 1)
fun sliceBeforeAndTrim(original: String, offset: Int): StringPair = sliceAfterAndTrim(original, offset - 1)
fun cut(original: String, token: Char): StringPair = cut(original, original.indexOf(token))
fun cutAndTrim(original: String, token: Char): StringPair = cutAndTrim(original, original.indexOf(token))