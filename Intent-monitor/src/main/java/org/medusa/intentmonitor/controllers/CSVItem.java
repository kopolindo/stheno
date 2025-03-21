package org.medusa.intentmonitor.controllers;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CSVItem {
    private int index;
    private String description;
    private String destinationPackage;
    private String destinationClass;
    private Boolean exported;
    private String bundleString;
}
