package lotto.domain;

import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ResultViewDto {
    private List<String> result;

    private ResultViewDto(Ranks ranks) {
        this.result = new ArrayList<>();

        List<Reward> rewards = Arrays.asList(Reward.values());
        OutputView.sortRewardOrdered(rewards);
        rewards.forEach(reward -> result.add(OutputView.printRank(reward, ranks.getRank(reward))));
    }

    public static ResultViewDto of(Ranks ranks) {
        return new ResultViewDto(ranks);
    }

    public List<String> getResult() {
        return Collections.unmodifiableList(result);
    }
}
