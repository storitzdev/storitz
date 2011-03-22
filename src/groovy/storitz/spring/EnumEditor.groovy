package storitz.spring

import java.beans.PropertyEditorSupport

public class EnumEditor extends PropertyEditorSupport {

  private Class<? extends Enum<?>> clazz

  public EnumEditor(Class<? extends Enum<?>> clazz) {
    this.clazz = clazz
  }

  public String getAsText() {
    return value?.display
  }

  public void setAsText(String text) {
    value = clazz.getEnumFromId(text)
  }
}