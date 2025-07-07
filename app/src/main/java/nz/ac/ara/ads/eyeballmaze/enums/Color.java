package nz.ac.ara.ads.eyeballmaze.enums;

import nz.ac.ara.ads.eyeballmaze.R;

public enum Color {
    RED, BLUE, YELLOW, GREEN;

    public int drawableIdFor(String shapeName) {
        String resourceName = "shape_" + shapeName + "_" + this.name().toLowerCase();
        return getDrawableIdByName(resourceName);
    }

    private int getDrawableIdByName(String name) {
        // Fallback-safe resource loading (will need context to be passed if not static)
        try {
            return R.drawable.class.getField(name).getInt(null);
        } catch (Exception e) {
            return R.drawable.line_none;
        }
    }
}