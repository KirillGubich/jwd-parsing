package com.epam.jwd.parser.factory;

import com.epam.jwd.parser.composite.TextComponent;
import com.epam.jwd.parser.exception.UnknownTextComponentException;
import com.epam.jwd.parser.model.ComponentType;

public interface ComponentFactory {

    TextComponent create(ComponentType componentType, String value) throws UnknownTextComponentException;
}
