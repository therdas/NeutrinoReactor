package base

data class FlagInstance (val S: Boolean,
                         val Z: Boolean,
                         val K: Boolean,
                         val AC: Boolean,
                         val P: Boolean,
                         val V: Boolean,
                         val C: Boolean)

class FlagConstructor{
    /**
     * FlagConstructor for Words and DWords
     */
    
    private var s: Boolean = false
    private var z: Boolean = false
    private var k: Boolean = false
    private var ac: Boolean = false
    private var p: Boolean = false
    private var v: Boolean = false
    private var c: Boolean = false

    fun getFinal(): FlagInstance {
        return FlagInstance(s, z, k, ac, p, v, c)
    }

    fun checkForS(result: Word) {
        s = result.data and( 0x80u ) > 1u
    }

    fun checkForZ(result: Word) {
        z = result.data == 0x00u.toUByte()
    }

    //Can only be called after checkForV is called, else stale result.
    fun checkForK(first: Word, second: Word) {
        val result: UByte = (first + second).data
        k = result and 0x80u > 0u && v
    }

    fun checkForAC(first: Word, second: Word) {
        val (a, b) = listOf(first.data.and(0x0Fu), second.data.and(0x0Fu))
        ac = (a + b) > 0x0Fu
    }

    fun checkForP(result: Word) {
        p = result.parity()
    }

    fun checkForV(first: Word, second: Word) {
        val mask: UByte = 0b01111111u
        val c6: Boolean = (first.data.and(mask) + second.data.and(mask)) > 0u
        val c7: Boolean = first.data + second.data > 0xFFu
        v = c6 and c7
    }

    fun checkForC(first: Word, second: Word) {
        c = first.data + second.data > 0xFFu
    }

    fun setCarry(value: Boolean) {
        this.c = value
    }

    /*Shortcut Functions*/
    fun checkForSZP(result: Word) {
        checkForZ(result)
        checkForS(result)
        checkForP(result)
    }
    
    fun checkForArithmetic(first: Word, second: Word) {
        checkForV(first, second)
        checkForK(first, second)
        checkForAC(first, second)
        checkForC(first, second)
    }
}
