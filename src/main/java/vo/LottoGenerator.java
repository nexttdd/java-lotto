package vo;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoGenerator {
    public static Lotto generateAuto() {
        List<Integer> seed = createSeed();
        Collections.shuffle(seed);
        return Lotto.of(new LinkedHashSet<>(seed.subList(0, 6)));
    }

    private static List<Integer> createSeed() {
        return IntStream.range(1, 46).boxed().collect(Collectors.toList());
    }

    public static Lottos generateByMoney(Money money, List<Lotto> manualLottos) {
        List<Lotto> lottos = new ArrayList<>();
        int manualCount = getManualCount(manualLottos);
        //수동 로또
        if(manualCount > 0){
            lottos.addAll(manualLottos);
        }
        //수동 로또 제외한 자동 로또 생성 TODO 서영이한테 효율적인 방법 물어보기
        for (int i = 0; i < money.getExceptManualCount(manualCount); i++) {
            lottos.add(generateAuto());
        }
        return new Lottos(lottos);
    }

    private static int getManualCount(List<Lotto> manualLottos) {
        return manualLottos == null ? 0 : manualLottos.size();
    }
}
