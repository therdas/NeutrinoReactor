package base

typealias CalculationContext = Pair<Word, FlagInstance>

class Word(val data: UByte) {

    operator fun unaryMinus(): Word = Word((this.data.toInt() * -1).toUByte())

    operator fun plus(other: Word): Word = Word((this.data + other.data).toUByte())

    operator fun minus(other: Word): Word = Word((this.data - other.data).toUByte())

    operator fun compareTo(other: Word) = (this.data - other.data).toInt()

    override fun equals(other: Any?): Boolean = (other is Word) && this.data == other.data;

    fun increment(): Word = this + Word(1u)

    fun decrement(): Word = this - Word(1u)

    fun parity(): Boolean {
        var x: UByte = this.data
        x = x xor (x.rotateRight(4))
        x = x xor (x.rotateRight(2))
        return x and 0x01u == 0x01u.toUByte()
    }

    override fun hashCode(): Int {
        return data.hashCode()
    }
}

class DWord(data: UInt) {
    private val data: UInt

    init {
        if(data < 0x0000u || data > 0xFFFFu) {
            this.data = data % 0xFFFFu
        } else {
            this.data = data;
        }
    }

    operator fun unaryMinus(): DWord = DWord((this.data.toInt() * -1).toUInt())

    operator fun plus(other: DWord): DWord = DWord(this.data + other.data)

    operator fun minus(other: DWord): DWord = DWord(this.data - other.data)

    operator fun compareTo(other: DWord) = (this.data - other.data).toInt()

    override fun equals(other: Any?): Boolean = (other is DWord) && this.data == other.data;

    fun increment(): DWord = this + DWord(1u)

    fun decrement(): DWord = this - DWord(1u)
}
