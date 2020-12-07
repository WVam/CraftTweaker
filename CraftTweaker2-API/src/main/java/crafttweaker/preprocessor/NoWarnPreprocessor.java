package crafttweaker.preprocessor;

import crafttweaker.CraftTweakerAPI;
import crafttweaker.runtime.ScriptFile;

/**
 * @author youyihj
 */
public class NoWarnPreprocessor extends PreprocessorActionBase {
    public static final String PREPROCESSOR_NAME = "nowarn";

    public NoWarnPreprocessor(String fileName, String preprocessorLine, int lineIndex) {
        super(fileName, preprocessorLine, lineIndex);
    }

    @Override
    public void executeActionOnFind(ScriptFile scriptFile) {
        CraftTweakerAPI.suppressWarnAndErrorFlag |= 0b01;
    }

    @Override
    public String getPreprocessorName() {
        return PREPROCESSOR_NAME;
    }
}
