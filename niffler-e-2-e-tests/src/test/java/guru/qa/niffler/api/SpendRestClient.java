package guru.qa.niffler.api;

import guru.qa.niffler.config.Config;

import java.io.IOException;
import javax.annotation.Nonnull;

import guru.qa.niffler.model.SpendJson;
import org.junit.jupiter.api.Assertions;

public class SpendRestClient extends BaseRestClient {

  public SpendRestClient() {
    super(Config.getConfig().getSpendUrl());
  }

  private final SpendService spendService = retrofit.create(SpendService.class);

  public @Nonnull SpendJson addSpend(SpendJson spend) {
    try {
      return spendService.addSpend(spend).execute().body();
    } catch (IOException e) {
      Assertions.fail("Can`t execute api call to niffler-spend: " + e.getMessage());
      return null;
    }
  }
}
