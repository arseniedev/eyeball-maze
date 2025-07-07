package nz.ac.ara.ads.eyeballmaze.enums;

import nz.ac.ara.ads.eyeballmaze.R;

public enum Shape {
    DIAMOND,
    CROSS,
    STAR,
    FLOWER,
    BLANK,
    LIGHTNING;

    public int getDrawable(Color color) {
        switch (this) {
            case STAR:
                return color.drawableIdFor("star");
            case CROSS:
                return color.drawableIdFor("cross");
            case DIAMOND:
                return color.drawableIdFor("diamond");
            case FLOWER:
                return color.drawableIdFor("flower");
            default:
                return R.drawable.line_none;
        }
    }
}