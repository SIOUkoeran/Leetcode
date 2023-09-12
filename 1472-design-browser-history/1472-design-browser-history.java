class BrowserHistory {

    private List<String> history;
    private int currentIdx = -1;
    private int limit = -1;
    public BrowserHistory(String homepage) {
        history = new ArrayList<String>();
        history.add(homepage);
        currentIdx = 0;
        limit = 0;
    }
    
    public void visit(String url) {
        if (++currentIdx < history.size())
            history.set(currentIdx, url);
        else
            history.add(url);
        limit = currentIdx;
    }
    
    public String back(int steps) {  
        currentIdx = Math.max(0, currentIdx -steps);
        return history.get(currentIdx);
    }
    
    public String forward(int steps) {
        currentIdx = Math.min(limit, currentIdx + steps);
        return history.get(currentIdx);
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */