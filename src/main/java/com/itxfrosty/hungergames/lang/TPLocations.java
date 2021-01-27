package com.itxfrosty.hungergames.lang;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.util.ArrayList;
import java.util.List;

public class TPLocations {

    @Getter public static List<Location> loc = new ArrayList<>();

    private static final Location pod1 = new Location(Bukkit.getWorld("world"),23,80,-14);
    private static final Location pod2 = new Location(Bukkit.getWorld("world"),34,80,-12);
    private static final Location pod3 = new Location(Bukkit.getWorld("world"),40,80,-8);
    private static final Location pod4 = new Location(Bukkit.getWorld("world"),51,80,-2);
    private static final Location pod5 = new Location(Bukkit.getWorld("world"),57,80,5);
    private static final Location pod6 = new Location(Bukkit.getWorld("world"),61,80,14);
    private static final Location pod7 = new Location(Bukkit.getWorld("world"),63,80,25);
    private static final Location pod8 = new Location(Bukkit.getWorld("world"),61,80,36);
    private static final Location pod9 = new Location(Bukkit.getWorld("world"),57,80,45);
    private static final Location pod10 = new Location(Bukkit.getWorld("world"),51,80,53);
    private static final Location pod11 = new Location(Bukkit.getWorld("world"),43,80,59);
    private static final Location pod12 = new Location(Bukkit.getWorld("world"),34,80,63);
    private static final Location pod13 = new Location(Bukkit.getWorld("world"),23,80,65);
    private static final Location pod14 = new Location(Bukkit.getWorld("world"),12,80,63);
    private static final Location pod15 = new Location(Bukkit.getWorld("world"),3,80,59);
    private static final Location pod16 = new Location(Bukkit.getWorld("world"),-4,80,53);
    private static final Location pod17 = new Location(Bukkit.getWorld("world"),-10,80,45);
    private static final Location pod18 = new Location(Bukkit.getWorld("world"),-14,80,36);
    private static final Location pod19 = new Location(Bukkit.getWorld("world"),-16,80,25);
    private static final Location pod20 = new Location(Bukkit.getWorld("world"),-14,80,14);
    private static final Location pod21 = new Location(Bukkit.getWorld("world"),-10,80,5);
    private static final Location pod22 = new Location(Bukkit.getWorld("world"),-4,80,-2);
    private static final Location pod23 = new Location(Bukkit.getWorld("world"),3,80,-8);
    private static final Location pod24 = new Location(Bukkit.getWorld("world"),-12,80,-12);

    public static void locationRegister() {
        loc.add(pod1);
        loc.add(pod2);
        loc.add(pod3);
        loc.add(pod4);
        loc.add(pod5);
        loc.add(pod6);
        loc.add(pod7);
        loc.add(pod8);
        loc.add(pod9);
        loc.add(pod10);
        loc.add(pod11);
        loc.add(pod12);
        loc.add(pod13);
        loc.add(pod14);
        loc.add(pod15);
        loc.add(pod16);
        loc.add(pod17);
        loc.add(pod18);
        loc.add(pod19);
        loc.add(pod20);
        loc.add(pod21);
        loc.add(pod22);
        loc.add(pod23);
        loc.add(pod24);
    }
}