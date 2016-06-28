// Test case for Issue 67
// https://github.com/typetools/checker-framework/issues/67

import java.util.*;

class Issue67{
  private static final String KEY = "key";
  private static final String KEY2 = "key2";
  void test() {
    Map<String, String> map = new HashMap<String, String>();
    if (map.containsKey(KEY)) {
      map.get(KEY).toString();  // no problem
    }
    if (map.containsKey(KEY2) && map.get(KEY2).toString() != null) { // error
      // do nothing
    }
  }
}
