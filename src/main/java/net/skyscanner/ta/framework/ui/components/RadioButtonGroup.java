package net.skyscanner.ta.framework.ui.components;

import lombok.Getter;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class RadioButtonGroup extends CommonPageElement {
    @Getter
    private Set<RadioButton> radioButtons = new HashSet<>();

    public void addRadioButton(RadioButton radioButton) {
        Objects.requireNonNull(radioButton, "Radio button cannot be null");
        radioButtons.add(radioButton);
        radioButton.setGroup(this);
    }

    public int getRadioButtonCount() {
        return radioButtons.size();
    }

    public void removeRadioButton(RadioButton radioButton) {
        Objects.requireNonNull(radioButton, "Radio button cannot be null");
        radioButtons.remove(radioButton);
        radioButton.setGroup(null);
    }

    @Override
    public String toString() {
        StringBuilder groupDescriptionBuilder = new StringBuilder();
        for (RadioButton button : radioButtons) {
            groupDescriptionBuilder.append(button);
            groupDescriptionBuilder.append(": ");
            if (button.isSelected()) {
                groupDescriptionBuilder.append("enabled\n");
            } else {
                groupDescriptionBuilder.append("disabled\n");
            }
        }
        return groupDescriptionBuilder.toString();
    }
}

