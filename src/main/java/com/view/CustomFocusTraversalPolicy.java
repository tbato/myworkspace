/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.view;

import java.awt.Component;
import java.awt.Container;
import java.awt.FocusTraversalPolicy;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class CustomFocusTraversalPolicy extends FocusTraversalPolicy{
    private ArrayList<Component> components;
    public CustomFocusTraversalPolicy(ArrayList<Component> components){
        this.components = components;
    }

    @Override
    public Component getComponentAfter(Container aContainer, Component aComponent) {
        int index = (components.indexOf(aComponent) + 1 ) % components.size();
        return components.get(index);
    }

    @Override
    public Component getComponentBefore(Container aContainer, Component aComponent) {
        int index = components.indexOf(aComponent) - 1;
        if(index < 0){
         index = components.size() - 1;
        }
        return components.get(index);
    }

    @Override
    public Component getFirstComponent(Container aContainer) {
        return components.get(0);
    }

    @Override
    public Component getLastComponent(Container aContainer) {
        return components.get(components.size() - 1);
    }

    @Override
    public Component getDefaultComponent(Container aContainer) {
        return components.get(0);
    }
      // Di chuyển con trỏ đến thành phần tiếp theo khi nhấn phím Tab
    public void focusNextComponentWithTabKey(Component currentComponent) {
            int currentIndex = components.indexOf(currentComponent);
            int nextIndex = (currentIndex + 1) % components.size();
            Component nextComponent = components.get(nextIndex);
            nextComponent.requestFocusInWindow();
        }
    // Di chuyển con trỏ đến thành phần tiếp theo khi nhấn phím Tab
    
    public void focusNextComponentWithEnterKey(Component currentComponent) {
            int currentIndex = components.indexOf(currentComponent);
            int nextIndex = (currentIndex + 1) % components.size();
            Component nextComponent = components.get(nextIndex);
            nextComponent.requestFocusInWindow();
        }
}
    

