package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class LottoNumbersSpec : DescribeSpec({
    describe("로또 번호 개수 검증") {
        context("로또 번호를 생성하면") {
            it("로또는 6개의 번호를 갖고있다.") {
                val lottoNumbers = LottoNumbers.random()

                lottoNumbers.values.size shouldBe 6
            }
        }

        context("로또 번호가 6개 보다 작은 경우") {
            it("예외가 발생한다.") {
                val numbers = setOf(1, 2, 3, 4, 5)
                shouldThrow<IllegalArgumentException> {
                    LottoNumbers.of(numbers)
                }
            }
        }

        context("로또 번호가 6개 보다 큰 경우") {
            it("예외가 발생한다.") {
                val numbers = setOf(1, 2, 3, 4, 5, 6, 7)
                shouldThrow<IllegalArgumentException> {
                    LottoNumbers.of(numbers)
                }
            }
        }
    }
})
