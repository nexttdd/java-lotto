package lotto.domain;

import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ResultViewDto {
    private List<String> result;

    public ResultViewDto(Ranks ranks) {
        this.result = new ArrayList<>();

        List<Reward> rewards = Arrays.asList(Reward.values());
        OutputView.sortRewardOrdered(rewards);
        rewards.forEach(reward -> convertToResultString(reward, ranks.getRank(reward)));
    }

    private void convertToResultString(Reward reward, Rank rank) {
        if (Reward.MISS.equals(reward)) return;

        String resultString = rank.getMatchCount() + "개 일치";
        if (Reward.SECOND.equals(reward)) {
            resultString += ", 보너스 볼 일치";
        }

        resultString += "("
                + rank.getWinningMoney()
                + "원)- "
                + rank.getTicketCount()
                + "개";

        this.result.add(resultString);
    }

    public List<String> getResult() {
        return Collections.unmodifiableList(result);
    }
}
