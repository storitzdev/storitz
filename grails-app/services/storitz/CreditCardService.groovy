package storitz

import storitz.constants.CreditCardType

class CreditCardService {

    boolean transactional = false

    def getCardType(String ccNum) {

      if (ccNum.size() < 12) return null

      def ccString = ccNum as String

      if (ccString.substring(0,1) == '4') return CreditCardType.VISA

      def ccNum2 = ccString.substring(0,2) as Integer

      if (ccNum2 >= 51 && ccNum2 <= 55) return CreditCardType.MASTERCARD
      if (ccNum2 == 34 || ccNum2 == 37) return CreditCardType.AMERICAN_EXPRESS
      if (ccNum2 == 36 || ccNum2 == 38) return CreditCardType.DINERSCLUB

      def ccNum3 = ccString.substring(0,3) as Integer

      if (ccNum3 >= 300 && ccNum3 <= 305) return CreditCardType.DINERSCLUB

      if (ccString.substring(0,4) == '6011') return CreditCardType.DISCOVER

      return null

    }
}
