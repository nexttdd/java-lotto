package lotto.view;

import lotto.domain.*;

import java.util.Set;

public class OutputView {
    public static void printTickets(LottoTickets lottoTickets) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");

        for (LottoTicket lottoTicket : lottoTickets.getTickets()) {
            System.out.println(lottoTicket.toString());
        }
        System.out.println();
    }

    public static void printRanks(Ranks ranks) {
        Set<Integer> results = ranks.getRanks().keySet();

        for (Integer rank : results) {
            printRank(ranks.getRanks().get(rank));
        }
    }

    private static void printRank(Rank rank) {
        int matchCount = rank.getMatchCount();
        int winningMoney = WinningMoney.winningMoney.get(matchCount);
        int ticketCount = rank.getTicketCount();
        System.out.println(matchCount + "개 일치 (" + winningMoney + "원)- " + ticketCount + "개");
    }

    public static void printProfit(double profit) {
        String result = "총 수익률은 " + profit + "입니다.";

        if (profit < 0) {
            result += "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
        }

        System.out.println(result);
    }
}