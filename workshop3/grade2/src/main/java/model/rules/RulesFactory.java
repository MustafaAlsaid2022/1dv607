package model.rules;

public class RulesFactory {

  public IHitStrategy GetHitRule() {
    return new SoftSevenTeenStrategy();
  }

  public INewGameStrategy GetNewGameRule() {
    return new AmericanNewGameStrategy();
  }
}