package de.jangassen.jfa;

import com.sun.jna.Pointer;
import de.jangassen.jfa.annotation.NamedArg;
import de.jangassen.jfa.foundation.Foundation;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Collectors;

public final class Selector {
  public  static Pointer forMethod(Method method) {
    return Foundation.createSelector(Selector.stringForMethod(method));
  }

  public static String stringForMethod(Method method) {
    if (method.getParameterCount() == 0) {
      return method.getName();
    }

    String parameterNames = Arrays.stream(method.getParameters())
            .skip(1)
            .map(Selector::getParameterNames)
            .map(p -> p + ":")
            .collect(Collectors.joining());

    return method.getName() + ":" + parameterNames;
  }

  private static String getParameterNames(Parameter p) {
    return Optional.ofNullable(p.getAnnotation(NamedArg.class))
            .map(NamedArg::value)
            .orElse("");
  }
}