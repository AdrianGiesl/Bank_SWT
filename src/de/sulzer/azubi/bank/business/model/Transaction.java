package de.sulzer.azubi.bank.business.model;

import java.time.LocalDateTime;

/**
 * The type Transaction.
 */
public class Transaction {

  private Long id;
  private Account source;
  private Account target;
  private String usage;
  private Double amount;
  private LocalDateTime timestamp;

  /**
   * Gets id.
   *
   * @return the id
   */
  public Long getId() {
    return id;
  }

  /**
   * Sets id.
   *
   * @param id the id
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Gets source.
   *
   * @return the source
   */
  public Account getSource() {
    return source;
  }

  /**
   * Sets source.
   *
   * @param source the source
   */
  public void setSource(Account source) {
    this.source = source;
  }

  /**
   * Gets target.
   *
   * @return the target
   */
  public Account getTarget() {
    return target;
  }

  /**
   * Sets target.
   *
   * @param target the target
   */
  public void setTarget(Account target) {
    this.target = target;
  }

  /**
   * Gets usage.
   *
   * @return the usage
   */
  public String getUsage() {
    return usage;
  }

  /**
   * Sets usage.
   *
   * @param usage the usage
   */
  public void setUsage(String usage) {
    this.usage = usage;
  }

  /**
   * Gets amount.
   *
   * @return the amount
   */
  public double getAmount() {
    return amount;
  }

  /**
   * Sets amount.
   *
   * @param amount the amount
   */
  public void setAmount(double amount) {
    this.amount = amount;
  }

  /**
   * Gets timestamp.
   *
   * @return the timestamp
   */
  public LocalDateTime getTimestamp() {
    return timestamp;
  }

  /**
   * Sets timestamp.
   *
   * @param timestamp the timestamp
   */
  public void setTimestamp(LocalDateTime timestamp) {
    this.timestamp = timestamp;
  }
}
