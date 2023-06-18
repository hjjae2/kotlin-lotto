package lotto.view

import lotto.domain.WinningNumbers

object LottoInputView {
    private const val WINNING_LOTTO_DELIMITER = ","

    fun inputMoney(): Int {
        return readLineWithMessage("구입금액을 입력해 주세요.").trim().toInt()
    }

    fun inputWinningLottoNumbers(): WinningNumbers {
        return readLineWithMessage("지난 주 당첨 번호를 입력해 주세요.")
            .split(WINNING_LOTTO_DELIMITER)
            .map { it.trim().toInt() }
            .toSet()
    }

    private fun readLineWithMessage(message: String): String {
        println(message)
        return readlnOrNull() ?: throw IllegalArgumentException("입력 값이 없습니다.")
    }
}