package lotto.view;

import lotto.domain.*;

import java.util.*;

public class OutputView {
    public static void printTickets(LottoMoney lottoMoney, LottoTickets lottoTickets) {
        System.out.println("\n수동으로 " + lottoMoney.getManualTicketCount() + "장,"
                + "자동으로 " + lottoMoney.getAutoTicketCount() + "개를 구매했습니다.");

        lottoTickets.getTickets()
                .forEach(System.out::println);
    }

    public static void printRanks(Ranks ranks) {
        System.out.println("\n당첨 통계");
        System.out.println("---------");

        List<Reward> rewards = Arrays.asList(Reward.values());
        sortRewardOrdered(rewards);

        for (Reward reward : rewards) {
            printRank(reward, ranks.getRanks().get(reward));
        }
    }

    private static void printRank(Reward reward, Rank rank) {
        if (Reward.MISS.equals(reward)) return;
        int ticketCount = rank.getTicketCount();

        String result = reward.getMatchCount() + "개 일치";
        if (Reward.SECOND.equals(reward)) {
            result += ", 보너스 볼 일치";
        }

        System.out.println(result + "(" + reward.getWinningMoney() + "원)- " + ticketCount + "개");
    }

    public static void printProfit(String profit) {
        String result = "총 수익률은 " + profit + "입니다.";

        if (Double.parseDouble(profit) < 1) {
            result += "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
        }

        System.out.println(result);
    }

    public static void sortRewardOrdered(List<Reward> rewards) {
        rewards.sort((o1, o2) -> {
            if (o1.getMatchCount() > o2.getMatchCount()) {
                return 1;
            }

            if (o1.getMatchCount() == o2.getMatchCount()) {
                if (o1.getWinningMoney() > o2.getWinningMoney()) {
                    return 1;
                }
                return -1;
            }

            return -1;
        });
    }
}