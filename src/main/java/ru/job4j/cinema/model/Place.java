package ru.job4j.cinema.model;

public class Place {
    private int id;
    private int row;
    private int cell;
    private boolean place;

    static public Place placeOf(int id, int row, int cell, boolean bool) {
        Place place = new Place();
        place.id = id;
        place.row = row;
        place.cell = cell;
        place.place = bool;
        return place;
    }

    public int getId() {
        return id;
    }

    public int getRow() {
        return row;
    }

    public int getCell() {
        return cell;
    }

    public boolean isPlace() {
        return place;
    }

    @Override
    public String toString() {
        return "Place{"
                + "id=" + id
                + ", row=" + row
                + ", cell=" + cell
                + ", place=" + place
                + '}';
    }
}
