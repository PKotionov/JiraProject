package com.epam.ta.bo;

/**
 * Created by Pavel_Kotionov on 6/13/2018.
 */
public class Repository {
    private String repoName, repoDescription;

    public Repository() {
    }

    public Repository(String repoName, String repoDescription) {
        this.repoName = repoName;
        this.repoDescription = repoDescription;
    }

    public Repository(RepositoryBuilder repositoryBuilder) {
        this.repoName = repositoryBuilder.repoName;
        this.repoDescription = repositoryBuilder.repoDescription;
    }

    public String getRepoName() {
        return repoName;
    }

    public String getRepoDescription() {
        return repoDescription;
    }

    public static class RepositoryBuilder{
        private String repoName, repoDescription;

        public RepositoryBuilder(String repoName, String repoDescription) {
            this.repoName = repoName;
            this.repoDescription = repoDescription;
        }

        public RepositoryBuilder() {
        }

        public RepositoryBuilder repoName(String repoName){
            this.repoName = repoName;
            return this;
        }

        public RepositoryBuilder repoDescription(String repoDescription){
            this.repoDescription = repoDescription;
            return this;
        }

        public Repository built(){
            return new Repository(this);
        }
    }
}
