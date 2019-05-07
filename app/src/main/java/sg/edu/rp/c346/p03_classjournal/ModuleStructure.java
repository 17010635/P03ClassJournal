package sg.edu.rp.c346.p03_classjournal;

import java.io.Serializable;

public class ModuleStructure implements Serializable {
    private String moduleCode;
    private String moduleName;

    public ModuleStructure(String moduleCode, String moduleName) {
        this.moduleCode = moduleCode;
        this.moduleName = moduleName;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }
}
