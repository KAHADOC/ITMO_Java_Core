package edu.itmo.java.exam1;

public enum TrainingArea {
    GYM_ZONE, SWIM_POOL, GROUP_CLASS;

    public static boolean validZone(Pass memberCard, TrainingArea zone) {
        boolean result = false;
        if (memberCard.getType() == PassType.SINGLE && (zone == TrainingArea.GYM_ZONE
                || zone == TrainingArea.SWIM_POOL)) result = true;
        if (memberCard.getType() == PassType.DAYTIME && (zone == TrainingArea.GYM_ZONE
                || zone == TrainingArea.GROUP_CLASS)) result = true;
        if (memberCard.getType() == PassType.FULL) result = true;
        return result;
    }
}
