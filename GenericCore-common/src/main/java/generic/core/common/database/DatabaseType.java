package generic.core.common.database;

public enum DatabaseType {
    REDIS{
        @Override
        public Database getConnection(String[] config){
            return new RedisDatabase(config);
        }

        @Override
        public boolean isValidBackupType() {
            return false;
        }
    }, MYSQL{
        @Override
        public Database getConnection(String[] config) {
            return null;
        }

        @Override
        public boolean isValidBackupType() {
            return false;
        }
    }, FIREBASE{
        @Override
        public Database getConnection(String[] config) {
            return null;
        }

        @Override
        public boolean isValidBackupType() {
            return true;
        }
    }, MONGODB{
        @Override
        public Database getConnection(String[] config) {
            return null;
        }

        @Override
        public boolean isValidBackupType() {
            return false;
        }
    }, YML{
        @Override
        public Database getConnection(String[] config) {
            return null;
        }

        @Override
        public boolean isValidBackupType() {
            return true;
        }
    }, JSON{
        @Override
        public Database getConnection(String[] config) {
            return new JsonDatabase(config);
        }

        @Override
        public boolean isValidBackupType() {
            return true;
        }
    };

    public abstract Database getConnection(String[] config);
    public abstract boolean isValidBackupType();
}
