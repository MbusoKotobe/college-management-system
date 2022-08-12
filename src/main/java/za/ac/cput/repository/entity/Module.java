package za.ac.cput.repository.entity;

/*
 * Zintle Magwaxaza (218109911)
 * Module.java
 * Date: 08 April 2022
 */

public class Module {
    private String moduleId;
    private String moduleName;
    private String moduleDescription;

    private Module(Builder builder)
    {
        this.moduleId = builder.moduleId;
        this.moduleName = builder.moduleName;
        this.moduleDescription = builder.moduleDescription;
    }

    public String getModuleId ()
    {
        return moduleId;
    }

    public String getModuleName ()
    {
        return moduleName;
    }

    public String getModuleDescription ()
    {
        return moduleDescription;
    }

    @Override
    public String toString() {
        return "Module{" +
                "moduleId='" + moduleId + '\'' +
                ", moduleName='" + moduleName + '\'' +
                ", moduleDescription='" + moduleDescription + '\'' + '}';

       }

    public static class Builder {

        String moduleId;
        String moduleName;
        String moduleDescription;

        public Module.Builder setModuleId(String moduleId) {
            this.moduleId = moduleId;
            return this;
        }

        public Module.Builder setModuleName(String moduleName) {
            this.moduleName = moduleName;
            return this;
        }

        public Module.Builder setModuleDescription(String moduleDescription) {
            this.moduleDescription = moduleDescription;
            return this;
        }

        public Builder copy(Module module) {
            this.moduleId = module.moduleId;
            this.moduleName = module.moduleName;
            this.moduleDescription = module.moduleDescription;
            return this;
        }

        public Module build() {
            return new Module(this);
        }

    }


}
