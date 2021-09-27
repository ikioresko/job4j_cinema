package ru.job4j.cinema.model;

import java.util.Objects;

public class Ticket {
    private int id;
    private int session;
    private int row;
    private int cell;
    private int accountId;

    public static Ticket ticketOf(int id, int session, int row, int cell, int accountId) {
        Ticket ticket = new Ticket();
        ticket.id = id;
        ticket.session = session;
        ticket.row = row;
        ticket.cell = cell;
        ticket.accountId = accountId;
        return ticket;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSession() {
        return session;
    }

    public int getRow() {
        return row;
    }

    public int getCell() {
        return cell;
    }

    public int getAccountId() {
        return accountId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ticket ticket = (Ticket) o;
        return id == ticket.id
                && session == ticket.session
                && row == ticket.row
                && cell == ticket.cell
                && accountId == ticket.accountId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, session, row, cell, accountId);
    }

    @Override
    public String toString() {
        return "Ticket{"
                + "id=" + id
                + ", session=" + session
                + ", row=" + row
                + ", cell=" + cell
                + ", accountId=" + accountId
                + '}';
    }
}
